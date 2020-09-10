<template>
  <a-modal
    title="字典值编辑"
    :width="900"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleSubmit"
    @cancel="handleCancel"
  >
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">
        <a-form-item
          style="display: none;"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input v-decorator="['id']" />
        </a-form-item>
        <a-form-item
          style="display: none;"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-input v-decorator="['typeId']" />
        </a-form-item>
        <a-form-item label="字典值" :labelCol="labelCol" :wrapperCol="wrapperCol" has-feedback>
          <a-input
            placeholder="请输入字典值"
            v-decorator="['value', {rules: [{required: true, message: '请输入字典值！'}]}]"
          />
        </a-form-item>
        <a-form-item label="唯一编码" :labelCol="labelCol" :wrapperCol="wrapperCol" has-feedback>
          <a-input
            placeholder="请输入唯一编码"
            v-decorator="['code', {rules: [{required: true, message: '请输入唯一编码！'}]}]"
            :disabled="true"
          />
        </a-form-item>
        <a-form-item label="标题" :labelCol="labelCol" :wrapperCol="wrapperCol" has-feedback>
          <a-input
            placeholder="请输入标题"
            v-decorator="['label', {rules: [{required: true, message: '请输入标题！'}]}]"
          />
        </a-form-item>

        <!-- <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="排序" has-feedback>
          <a-input-number
            style="width: 100%"
            placeholder="请输入排序"
            v-decorator="['sort', { initialValue: 100 }]"
            :min="1"
            :max="1000"
          />
        </a-form-item>

        <a-form-item label="备注" :labelCol="labelCol" :wrapperCol="wrapperCol" has-feedback>
          <a-textarea :rows="4" placeholder="请输入备注" v-decorator="['remark']"></a-textarea>
        </a-form-item> -->
      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
import { save, update } from '@/api/sys/dictItem'
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
      visible: false,
      confirmLoading: false,
      form: this.$form.createForm(this),
      dictItemId: undefined
    }
  },
  methods: {
    // 初始化方法
    edit (record) {
      this.visible = true
      if (record === undefined) {
        this.dictItemId = undefined
          setTimeout(() => {
          this.form.setFieldsValue({
            code: record.code
          })
        }, 100)
      } else {
        this.dictItemId = record.id
        setTimeout(() => {
          this.form.setFieldsValue({
            id: record.id,
            typeId: record.typeId,
            value: record.value,
            code: record.code,
            label: record.label
          })
        }, 100)
      }
    },

    handleSubmit () {
      const {
        form: { validateFields }
      } = this
      this.confirmLoading = true
      validateFields((errors, values) => {
        if (!errors) {
          if (this.dictItemId === undefined) {
             save(values)
              .then((res) => {
                if (res.status === 200) {
                  this.$message.success('添加成功')
                  this.visible = false
                  this.confirmLoading = false
                  this.$emit('ok', values)
                  this.form.resetFields()
                } else {
                  this.$message.error('添加失败：' + res.message)
                }
              })
              .finally((res) => {
                this.confirmLoading = false
              })
          } else {
            update(values)
              .then((res) => {
                if (res.status === 200) {
                  this.$message.success('编辑成功')
                  this.visible = false
                  this.confirmLoading = false
                  this.$emit('ok', values)
                  this.form.resetFields()
                } else {
                  this.$message.error('编辑失败：' + res.message)
                }
              })
              .finally((res) => {
                this.confirmLoading = false
              })
          }
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
