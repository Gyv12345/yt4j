<template>
  <a-modal
    title="角色编辑"
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

        <a-form-item label="角色名" :labelCol="labelCol" :wrapperCol="wrapperCol" has-feedback>
          <a-input
            placeholder="请输入角色名"
            v-decorator="['name', {rules: [{required: true, message: '请输入角色名！'}]}]"
          />
        </a-form-item>

        <a-form-item label="角色标识" :labelCol="labelCol" :wrapperCol="wrapperCol" has-feedback>
          <a-input
            placeholder="请输入角色标识"
            v-decorator="['code', {rules: [{required: true, message: '请输入角色标识！'}]}]"
          />
        </a-form-item>
        <a-form-item
          label="授权范围"
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          has-feedback
        >
          <a-select style="width: 100%" placeholder="请选择授权范围" v-decorator="['level', {rules: [{ required: true, message: '请选择授权范围！' }]}]" >
            <a-select-option v-for="(item, index) in dataScopeTypeData" :key="index" :value="item.value">{{ item.label }}</a-select-option>
          </a-select>
        </a-form-item>

        <!-- <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="排序" has-feedback>
          <a-input-number
            style="width: 100%"
            placeholder="请输入排序"
            v-decorator="['sort', { initialValue: 100 }]"
            :min="1"
            :max="1000"
          />
        </a-form-item> -->
      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
import { save, update } from '@/api/sys/role'
import { remote } from '@/api/sys/dict'
// import { saveSub } from '@/api/manage'
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
      id: undefined,
      // 授权范围数据
      dataScopeTypeData: []
    }
  },
  methods: {
    // 初始化方法
    edit (record) {
      this.visible = true
      if (record !== undefined) {
        this.id = record.id
        this.form.getFieldDecorator('level', { initialValue: record.level?.toString() })
        setTimeout(() => {
          this.form.setFieldsValue({
            id: record.id,
            name: record.name,
            code: record.code
          })
        }, 100)
      } else {
        this.form.getFieldDecorator('level', { initialValue: undefined })
        this.id = undefined
      }
      this.sysDictTypeDropDown()
    },

    /**
      * 获取字典数据
      */
    sysDictTypeDropDown () {
      // 数据范围
      remote('data_scope_type').then((res) => {
        this.dataScopeTypeData = res.result
      })
    },
    handleSubmit () {
      const {
        form: { validateFields }
      } = this
      this.confirmLoading = true
      validateFields(async (errors, values) => {
        if (!errors) {
          if (this.id === undefined) {
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
              values.id = this.id
              const res = await update(values)
              if (res.status === 200) {
                  this.$message.success('编辑成功')
                  this.visible = false
                  this.confirmLoading = false
                  this.$emit('ok', values)
                  this.form.resetFields()
              } else {
                  this.$message.error('编辑失败：' + res.message)
              }
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
