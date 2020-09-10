<template>
  <page-header-wrapper>
    <a-card :bordered="false">
      <div class="table-page-search-wrapper">
        <a-form layout="inline">
          <a-row :gutter="48">
            <a-col :md="8" :sm="24">
              <a-form-item label="角色名">
                <a-input v-model="queryParam.name" allow-clear placeholder="请输入角色名" />
              </a-form-item>
            </a-col>
            <a-col :md="8" :sm="24">
              <a-form-item label="角色标识">
                <a-input v-model="queryParam.code" allow-clear placeholder="请输入角色标识" />
              </a-form-item>
            </a-col>
            <a-col :md="8" :sm="24">
              <a-button type="primary" @click="$refs.table.refresh(true)">查询</a-button>
              <a-button style="margin-left: 8px" @click="() => queryParam = {}">重置</a-button>
            </a-col>
          </a-row>
        </a-form>
      </div>
      <div class="table-operator">
        <a-button type="primary" icon="plus" @click="$refs.editForm.edit()">新增角色</a-button>
      </div>
      <s-table
        ref="table"
        size="default"
        :columns="columns"
        :data="loadData"
        :alert="true"
        :rowKey="(record) => record.code"
        :rowSelection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
      >
        <span slot="action" slot-scope="text, record">
          <a @click="$refs.editForm.edit(record)">编辑</a>
          <a-divider type="vertical" />
          <a-dropdown>
            <a class="ant-dropdown-link">
              更多
              <a-icon type="down" />
            </a>
            <a-menu slot="overlay">
              <a-menu-item>
                <a @click="$refs.roleMenuForm.roleMenu(record)">授权菜单</a>
              </a-menu-item>
              <a-menu-item>
                <a-popconfirm
                  placement="topRight"
                  title="确认删除？"
                  @confirm="() => sysRoleDelete(record)"
                >
                  <a>删除</a>
                </a-popconfirm>
              </a-menu-item>
            </a-menu>
          </a-dropdown>
        </span>
      </s-table>

      <edit-form ref="editForm" @ok="handleOk" />
      <role-menu-form ref="roleMenuForm" @ok="handleOk"/>
      <!-- <add-form ref="addForm" @ok="handleOk" />
      <edit-form ref="editForm" @ok="handleOk" />
      <role-menu-form ref="roleMenuForm" @ok="handleOk"/>
      <role-org-form ref="roleOrgForm" @ok="handleOk"/>-->
    </a-card>
  </page-header-wrapper>
</template>

<script>
  import { STable } from '@/components'
  import { list, del } from '@/api/sys/role'
//   import addForm from './addForm'
  import editForm from './editForm'
  import roleMenuForm from './roleMenuForm'
//   import roleOrgForm from './roleOrgForm'

  export default {
    components: {
      STable,
    //   addForm,
      editForm,
      roleMenuForm
    //   roleOrgForm
    },

    data () {
        return {
            // 查询参数
            queryParam: {},
            // 表头
            columns: [
            {
                title: '角色名',
                dataIndex: 'name'
            },
            {
                title: '角色标识',
                dataIndex: 'code'
            },
            {
                title: '排序',
                dataIndex: 'sort'
            }
            ],
            // 加载数据方法 必须为 Promise 对象
            loadData: parameter => {
                return list(Object.assign(parameter, this.queryParam)).then((res) => {
                    return res.result
                })
            },
            selectedRowKeys: [],
            selectedRows: []
        }
    },
    created () {
        this.columns.push({
          title: '操作',
          width: '150px',
          dataIndex: 'action',
          scopedSlots: { customRender: 'action' }
        })
    },
    methods: {
      sysRoleDelete (record) {
        del(record.id).then((res) => {
          if (res.status === 200) {
            this.$message.success('删除成功')
            this.$refs.table.refresh()
          } else {
            this.$message.error('删除失败：' + res.message)
          }
        }).catch((err) => {
          this.$message.error('删除错误：' + err.message)
        })
      },
      handleOk () {
        this.$refs.table.refresh()
      },
      onSelectChange (selectedRowKeys, selectedRows) {
        this.selectedRowKeys = selectedRowKeys
        this.selectedRows = selectedRows
      }
    }

  }
</script>

<style lang="less">
  .table-operator {
    margin-bottom: 18px;
  }
  button {
    margin-right: 8px;
  }

</style>
