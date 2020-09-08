<template>
  <a-modal
    title="新增机构"
    :width="900"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleSubmit"
    @cancel="handleCancel"
  >
    <a-spin :spinning="formLoading">
      <a-form :form="form">
        <a-form-item
          label="机构名称"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入机构名称" v-decorator="['label', {rules: [{required: true, message: '请输入机构名称！'}]}]" />
        </a-form-item>

        <!-- <a-form-item
          label="唯一编码"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input placeholder="请输入唯一编码" v-decorator="['code', {rules: [{required: true, message: '请输入唯一编码！'}]}]" />
        </a-form-item> -->

        <a-form-item
          label="上级机构"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-tree-select
            v-decorator="['parentId', {rules: [{ required: true, message: '请选择上级机构！' }]}]"
            style="width: 100%"
            :dropdownStyle="{ maxHeight: '300px', overflow: 'auto' }"
            :treeData="orgTree"
            placeholder="请选择上级机构"
            treeDefaultExpandAll
            :replaceFields="replaceFields"
          >
            <span slot="name" slot-scope="{ id }">
              {{ id }}
            </span>
          </a-tree-select>
        </a-form-item>

        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="排序"
        >
          <a-input-number placeholder="请输入排序" style="width: 100%" v-decorator="['orderNo', { initialValue: 100 }]" :min="1" :max="1000" />
        </a-form-item>

        <!-- <a-form-item
          label="备注"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-textarea :rows="4" placeholder="请输入备注" v-decorator="['remark']"></a-textarea>
        </a-form-item> -->

      </a-form>

    </a-spin>
  </a-modal>
</template>

<script>
import { save, tree } from '@/api/sys/dept'

export default {
  data () {
    return {
      labelCol: {
        xs: { span: 24 },
        sm: { span: 5 }
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 15 }
      },
      replaceFields: {
        key: 'id',
        title: 'name',
        value: 'id'
      },
      orgTree: [],
      visible: false,
      confirmLoading: false,
      formLoading: true,
      form: this.$form.createForm(this)
    }
  },
  methods: {
    // 初始化方法
    add () {
      this.visible = true
      this.getOrgTree()
    },
    /**
     * 获取机构树，并加载于表单中
     */
    getOrgTree () {
      tree().then((res) => {
        this.formLoading = false
        if (res.status !== 200) {
          this.orgTree = []
          return
        }
        // this.orgTree = res.result
        this.orgTree = [{
          'id': '0',
          'parentId': '0',
          'name': '顶级',
          'value': '0',
          'pid': '0',
          'children': res.result
        }]
        console.log(121212, this.orgTree)
      })
    },

    handleSubmit () {
      const { form: { validateFields } } = this
      this.confirmLoading = true
      validateFields((errors, values) => {
        if (!errors) {
          save(values).then((res) => {
            if (res.status === 200) {
              this.$message.success('新增成功')
              this.visible = false
              this.confirmLoading = false
              this.$emit('ok', values)
              this.form.resetFields()
            } else {
              this.$message.error('新增失败：' + res.message)
            }
          }).finally((res) => {
            this.confirmLoading = false
          })
        } else {
          this.confirmLoading = false
        }
      })
    },
    handleCancel () {
      this.form.resetFields()
      this.visible = false
    }
  }
}
</script>
