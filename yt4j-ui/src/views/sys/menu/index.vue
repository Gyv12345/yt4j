<template>
  <a-card :bordered="false">
    <div class="table-operator">
      <a-button
        type="primary"
        icon="plus"
        @click="$refs.editForm.edit()"
      >
        新增菜单
      </a-button>
    </div>

    <!--<div class="ant-alert ant-alert-info" style="margin-bottom: 16px;">
      <i class="anticon anticon-info-circle ant-alert-icon"></i>已选择&nbsp;<a style="font-weight: 600">{{this.selectedRowKeys.length }}</a>项&nbsp;&nbsp;
      <a style="margin-left: 24px" @click="clearSele()">清空</a>
    </div>-->

    <a-table
      ref="table"
      :rowKey="(record) => record.id"
      :pagination="false"
      :defaultExpandAllRows="true"
      :columns="columns"
      :dataSource="data"
      :loading="loading"
      showPagination="auto"
      :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
    >
      <!--:rowSelection="rowSelectionon"-->

      <span slot="type" slot-scope="text">{{ typeFilter(text) }}</span>

      <span slot="icon" slot-scope="text">
        <div v-if="text != ''">
          <a-icon :type="text" />
        </div>
      </span>

      <span slot="action" slot-scope="text, record">
        <template>
          <a @click="$refs.editForm.edit(record)">编辑</a>
          <a-divider type="vertical" />
          <a-popconfirm
            placement="topRight"
            title="删除本菜单与下级？"
            @confirm="() => handleDel(record)"
          >
            <a>删除</a>
          </a-popconfirm>
        </template>
      </span>
    </a-table>
    <edit-form ref="editForm" @ok="handleOk" />
  </a-card>
</template>

<script>
import { tree, del } from '@/api/sys/menu'
// import addForm from './addForm'
import editForm from './editForm'
import { remote } from '@/api/sys/dict'

export default {
  components: {
    editForm
  },

  data () {
    return {
      data: [],
      loading: true,
      columns: [
        {
          title: '菜单名称',
          dataIndex: 'name',
          width: '20%'
        },
        // {
        //   title: '菜单类型',
        //   dataIndex: 'type',
        //   scopedSlots: { customRender: 'type' }
        // },
        {
          title: '图标',
          dataIndex: 'icon',
          scopedSlots: { customRender: 'icon' }
        },
        {
          title: '组件',
          dataIndex: 'component',
          ellipsis: true
        },
        {
          title: '路由地址',
          dataIndex: 'path',
          key: 'path',
          ellipsis: true
        },
        {
          title: '排序',
          dataIndex: 'orderNo'
        }
      ],
      selectedRowKeys: [],
      typeDict: []
    }
  },

  created () {
    this.loadData()
    // if (this.hasPerm('sysMenu:edit') || this.hasPerm('sysMenu:delete')) {
      this.columns.push({
        title: '操作',
        dataIndex: 'action',
        width: '150px',
        scopedSlots: { customRender: 'action' }
      })
    // }
  },

  methods: {
    loadData () {
      this.loading = true
      tree()
        .then((res) => {
          if (res.status === 200) {
            this.data = res.result
          }
        })
        .finally(() => {
          this.loading = false
        })
    //   this.sysDictTypeDropDown()
    },

    typeFilter (type) {
      const typeValue = this.typeDict.filter((item) => item.code === type)
      if (typeValue.length > 0) {
        return typeValue[0].value
      }
    },

    /**
     * 获取字典数据
     */
    sysDictTypeDropDown () {
      remote({ code: 'menu_type' }).then((res) => {
        this.typeDict = res.data
      })
    },

    refreshSel () {
      this.loadData()
    },
    handleOk () {
      this.loadData()
    },
    handleDel (record) {
      del(record)
        .then((res) => {
          if (res.status === 200) {
            this.$message.success('删除成功')
            this.loadData()
          } else {
            this.$message.error('删除失败：' + res.message)
          }
        })
        .catch((err) => {
          this.$message.error('错误：' + err.message)
        })
    },

    onSelectChange (selectedRowKeys) {
      this.selectedRowKeys = selectedRowKeys
    },
    clearSele () {
      this.selectedRowKeys = []
    }
  }
}
</script>
<style scoped>
.table-operator {
  margin-bottom: 18px;
}
button {
  margin-right: 8px;
}
</style>
