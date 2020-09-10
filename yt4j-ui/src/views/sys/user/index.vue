<template>
  <page-header-wrapper>
    <a-row :gutter="24">
      <a-col :md="5" :sm="24">
        <a-card :bordered="false" :loading="false">
          <div v-if="this.orgTree.length > 0">
            <a-tree
              :tree-data="orgTree"
              v-if="orgTree.length"
              @select="handleClick"
              :defaultExpandAll="true"
              :defaultExpandedKeys="defaultExpandedKeys"
              :replaceFields="replaceFields"
            />
          </div>
          <!-- :replaceFields="replaceFields" -->
          <div v-else>
            <a-empty :image="simpleImage" />
          </div>
        </a-card>
      </a-col>
      <a-col :md="19" :sm="24">
        <a-card :bordered="false">
          <!-- <div class="table-page-search-wrapper">
            <a-form layout="inline">
              <a-row :gutter="48">
                <a-col :md="8" :sm="24">
                  <a-form-item label="关键词">
                    <a-input v-model="queryParam.label" allow-clear placeholder="请输入机构名称" />
                  </a-form-item>
                </a-col>
                <a-col :md="8" :sm="24">
                  <a-form-item label="状态">
                    <a-input v-model="queryParam.label" allow-clear placeholder="请输入机构名称" />
                  </a-form-item>
                </a-col>
                <a-col :md="8" :sm="24">
                  <a-button type="primary" @click="$refs.table.refresh(true)">查询</a-button>
                  <a-button style="margin-left: 8px" @click="() => queryParam = {}">重置</a-button>
                </a-col>
                <a-col :md="8" :sm="24"></a-col>
              </a-row>
            </a-form>
          </div> -->
          <div class="table-operator">
            <a-button type="primary" icon="plus" @click="$refs.addForm.add()">新增用户</a-button>
          </div>
          <s-table
            ref="table"
            size="default"
            :rowKey="(record) => record.id"
            :columns="columns"
            :data="loadData"
            :alert="true"
            showPagination="auto"
          >
            <span slot="serial" slot-scope="text, record, index">{{ index + 1 }}</span>
            <span slot="status" slot-scope="text">
              <a-badge :status="text | statusTypeFilter" :text="text | statusFilter" />
            </span>
            <span slot="description" slot-scope="text">
              <ellipsis :length="4" tooltip>{{ text }}</ellipsis>
            </span>

            <span slot="action" slot-scope="text, record">
              <a @click="$refs.addForm.add(record)">编辑</a>
              <a-divider type="vertical" />
              <a-dropdown>
                <a class="ant-dropdown-link">
                  更多
                  <a-icon type="down" />
                </a>
                <a-menu slot="overlay">
                  <a-menu-item>
                    <a-popconfirm placement="topRight" title="确认重置密码？" @confirm="() => resetPwd(record)">
                      <a>重置密码</a>
                    </a-popconfirm>
                  </a-menu-item>
                  <a-menu-item>
                    <a-popconfirm placement="topRight" title="确认删除？" @confirm="() => sysUserDelete(record)">
                      <a>删除</a>
                    </a-popconfirm>
                  </a-menu-item>
                </a-menu>
              </a-dropdown>
            </span>
          </s-table>
          <add-form ref="addForm" @ok="handleOk" />
          <!-- <edit-pwd-form ref="editForm" @ok="handleOk" /> -->
          <!-- <edit-form ref="editForm" @ok="handleOk" />
          <user-role-form ref="userRoleForm" @ok="handleOk"/>
          <user-org-form ref="userOrgForm" @ok="handleOk"/> -->
        </a-card>
      </a-col>
    </a-row>
  </page-header-wrapper>
</template>

<script>
// ant-design-vue
import { Empty } from 'ant-design-vue'
// components
import { Ellipsis, STable } from '@/components'
import addForm from './addForm'
// import editForm from './editForm'
// import userRoleForm from './userRoleForm'
// import userOrgForm from './userOrgForm'
// api
import { list, password, del } from '@/api/sys/user'
import { tree } from '@/api/sys/dept'

export default {
  name: 'Index',
  components: {
    STable,
    Ellipsis,
    addForm
    // editForm,
    // userRoleForm,
    // userOrgForm,
  },
  data () {
    return {
      // 树形列表加载
      treeLoading: true,
      // 展开展开节点的树
      defaultExpandedKeys: [],
      // 树形列表数据
      orgTree: [],
      // 没有数据的时候显示
      simpleImage: Empty.PRESENTED_IMAGE_SIMPLE,
      // 替换 treeNode 中key 字段为 treeData 里面的 id
      replaceFields: {
        key: 'id',
        title: 'name'
      },
      columns: [
        {
          title: '编号',
          scopedSlots: { customRender: 'serial' }
        },
        {
          title: '昵称',
          dataIndex: 'nickName'
        },
        {
          title: '用户名',
          dataIndex: 'username'
        },
        {
          title: '状态',
          dataIndex: 'state',
          needTotal: true
        },
        {
          title: '更新时间',
          dataIndex: 'updateTime'
        },
        {
          title: '操作',
          scopedSlots: { customRender: 'action' }
        }
      ],
      // 查询条件参数
      queryParam: {},
      // 加载数据方法 必须为 Promise 对象
      loadData: (parameter) => {
        const requestParameters = Object.assign({}, parameter, this.queryParam)
        console.log('loadData request parameters:', requestParameters)
        return list(requestParameters).then((res) => {
          return res.result
        })
      },
      selectedRowKeys: [],
      selectedRows: []
    }
  },
  created () {
    // 获取树状列表
    this.getOrgTree()
  },
  methods: {
    /**
     * 点击左侧机构树查询列表
     * @param e 事件
     */
    handleClick (e) {
      if (e.length > 0) {
        this.queryParam = {
          'deptId': Number(e.toString())
        }
      } else {
        this.queryParam = {}
      }
      this.$refs.table.refresh(true)
    },
    /**
     * 异步获取组织树
     */
    async getOrgTree () {
      const res = await tree()

      this.treeLoading = false
      // 如果返回失败,不做任何处理
      if (res.status !== 200) {
        return
      }
      this.orgTree = res.result
      for (var item of res.result) {
        // parentId 为0时候,默认展开
        // 展开顶级菜单
        if (item.parentId === 0) {
          this.defaultExpandedKeys.push(item.id)
        }
      }
    },
    /**
     * 弹窗成功回调
     */
    handleOk () {
      this.$refs.table.refresh()
    },
     /**
     * 修改密码
     */
    resetPwd (record) {
      password({ id: record.id }).then(res => {
        if (res.status === 200) {
          this.$message.success('重置成功')
          // this.$refs.table.refresh()
        } else {
          this.$message.error('重置失败：' + res.message)
        }
      })
    },
    /**
     * 删除用户
     * @param record
     */
    sysUserDelete (record) {
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
    }
  }
}
</script>

<style scoped>
</style>
