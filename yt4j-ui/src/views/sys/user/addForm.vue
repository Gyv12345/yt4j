<template>
  <a-modal
    title="用户增加"
    :width="900"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleSubmit"
    @cancel="handleCancel"
  >
    <a-spin :spinning="confirmLoading">

      <a-divider orientation="left">基本信息</a-divider>

      <a-row :gutter="24">
        <a-col :md="12" :sm="24">
          <a-form :form="form">
            <a-form-item
              label="用户名"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              has-feedback
            >
              <a-input placeholder="请输入用户名" v-decorator="['username', {rules: [{required: true, min: 5, message: '请输入至少五个字符的账号！'}]}]" />
            </a-form-item>
          </a-form>
        </a-col>
        <!-- <a-col  :md="12" :sm="24" >
          <a-form :form="form">
            <a-form-item
              label="姓名"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              has-feedback
            >
              <a-input placeholder="请输入姓名" v-decorator="['name', {rules: [{required: true,  message: '请输入姓名！'}]}]" />
            </a-form-item>
          </a-form>
        </a-col> -->
        <a-col :md="12" :sm="24">
          <a-form :form="form">
            <a-form-item
              label="昵称"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              has-feedback
            >
              <a-input placeholder="请输入昵称" v-decorator="['nickName']" />
            </a-form-item>
          </a-form>
        </a-col>
      </a-row>

      <a-row :gutter="24" v-if="!isEdit">
        <a-col :md="12" :sm="24">
          <a-form :form="form">
            <a-form-item
              label="密码"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              has-feedback
            >
              <a-input
                placeholder="请输入密码"
                type="password"
                v-decorator="['password', {rules: [{required: true, message: '请输入密码！'},{
                  validator: validateToNextPassword,
                },]}]" />
            </a-form-item>
          </a-form>
        </a-col>
        <a-col :md="12" :sm="24">
          <a-form :form="form">
            <a-form-item
              label="重复密码"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              has-feedback
            >
              <a-input
                placeholder="请再次输入密码"
                type="password"
                v-decorator="['confirm', { rules: [{required: true, message: '请再次输入密码！'}, {validator: compareToFirstPassword}]}]"
              />
            </a-form-item>
          </a-form>
        </a-col>
      </a-row>

      <!-- <a-row :gutter="24">
        <a-col  :md="12" :sm="24">
          <a-form :form="form">
            <a-form-item
              label="生日"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              has-feedback
            >
              <a-date-picker placeholder="请选择生日"  @change="onChange" style="width: 100%" v-decorator="['birthday']" />
            </a-form-item>
          </a-form>
        </a-col>
      </a-row> -->

      <a-row :gutter="24">
        <a-col :md="12" :sm="24">
          <a-form :form="form">
            <a-form-item
              label="性别"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
            >
              <a-radio-group v-decorator="['sex',{rules: [{ required: true, message: '请选择性别！' }]}]" >
                <a-radio :value="1">男</a-radio>
                <a-radio :value="2">女</a-radio>
              </a-radio-group>
            </a-form-item>
          </a-form>
        </a-col>
        <a-col :md="12" :sm="24">
          <a-form :form="form">
            <a-form-item
              label="邮箱"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              has-feedback
            >
              <a-input placeholder="请输入邮箱" v-decorator="['email']" />
            </a-form-item>
          </a-form>
        </a-col>
      </a-row>

      <a-row :gutter="24">
        <a-col :md="12" :sm="24">
          <a-form :form="form">
            <a-form-item
              label="手机号"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              has-feedback
            >
              <a-input placeholder="请输入手机号" v-decorator="['phone',{rules: [{ required: true, message: '请输入手机号！' }]}]" />
            </a-form-item>
          </a-form>
        </a-col>
        <a-col :md="12" :sm="24">
          <a-form :form="form">
            <a-form-item
              label="身份证号"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              has-feedback
            >
              <a-input placeholder="请输入身份证号" v-decorator="['idCard']" />
            </a-form-item>
          </a-form>
        </a-col>
      </a-row>

      <a-divider orientation="left">员工信息</a-divider>

      <a-row :gutter="24">
        <a-col :md="12" :sm="24">
          <a-form :form="form">
            <a-form-item
              label="机构"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              has-feedback
            >
              <a-tree-select
                v-decorator="['deptId', {rules: [{ required: true, message: '请选择机构！' }]}]"
                style="width: 100%"
                :dropdownStyle="{ maxHeight: '300px', overflow: 'auto' }"
                :treeData="orgTree"
                placeholder="请选择机构"
                treeDefaultExpandAll
                @change="e => initrOrgName(e)"
                :replaceFields="replaceFields"
              >
                <span slot="name" slot-scope="{ id }">
                  {{ id }}
                </span>
              </a-tree-select>
            </a-form-item>
          </a-form>
        </a-col>
      </a-row>
      <a-row :gutter="24">
        <a-col :md="12" :sm="24">
          <a-form :form="form">
            <a-form-item
              label="选择角色"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              @change="handleChange"
            >
              <a-select
                mode="multiple"
                style="width: 100%"
                placeholder="请选择角色"
                v-decorator="['roleIds']"
              >
                <a-select-option v-for="item in loadData" :key="item.value" :value="item.value">
                  {{ item.label }}
                </a-select-option>
              </a-select>
            </a-form-item>
          </a-form>
        </a-col>
      </a-row>

      {{ roleIdValue }}
      <!-- <a-card>
        <div>
          <a-table
            :row-selection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
            :columns="columns"
            :dataSource="loadData"
            :pagination="false"
            :loading="roleLoading"
            :rowKey="(record) => record.value"
          />
        </div>
      </a-card> -->

      <!-- <a-row :gutter="24">
        <a-col  :md="24" :sm="24">
          <a-form :form="form">
            <a-form-item
              label="职位信息"
              :labelCol="labelCol_JG"
              :wrapperCol="wrapperCol_JG"
              has-feedback
            >
              <a-select
                mode="multiple"
                style="width: 100%"
                placeholder="请选择职位信息"
                v-decorator="['sysEmpParam.posIdList', {rules: [{ required: true, message: '请选择职位信息！' }]}]"
              >
                <a-select-option v-for='(item,index) in posList' :key="index" :value="item.id">{{item.name}}</a-select-option>
              </a-select>
            </a-form-item>
          </a-form>
        </a-col>
      </a-row> -->
    </a-spin>
  </a-modal>
</template>

<script>
import { save, update, get } from '@/api/sys/user'
import { tree, list } from '@/api/sys/dept'
import { listSelect } from '@/api/sys/role'
  // import { sysPosList } from '@/api/modular/system/posManage'
  // import moment from 'moment'
const columns = [
  {
    title: '角色名称',
    dataIndex: 'label'
  },
  {
    title: '角色标识',
    dataIndex: 'value'
  }
]

export default {
    data () {
      return {
        labelCol: {
          xs: { span: 24 },
          sm: { span: 6 }
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 }
        },
        // 机构行样式
        labelCol_JG: {
          xs: { span: 24 },
          sm: { span: 3 }
        },
        wrapperCol_JG: {
          xs: { span: 24 },
          sm: { span: 20 }
        },
        count: 1,
        visible: false,
        confirmLoading: false,
        orgTree: [],
        orgList: [],
        // posList: [],
        sysEmpParamExtList: [],
        memberLoading: false,
        form: this.$form.createForm(this),
        data: [],
        birthdayString: [],
        replaceFields: {
          key: 'id',
          title: 'name',
          value: 'id'
        },
        isEdit: false,
        userId: undefined,
        // 角色选择列表
        columns,
        loadData: [],
        selectedRowKeys: [], // Check here to configure the default column
        roleLoading: false,
        roleIdValue: []
      }
    },
    methods: {
      // 初始化方法
      async add (record) {
        this.visible = true
        // 获取组织机构数据
        this.getOrgDate()

        if (record !== undefined) {
          this.isEdit = true
          await this.delay()
          this.form.setFieldsValue(
            {
              id: record.id,
              username: record.username,
              nickName: record.nickName,
              sex: record.sex,
              email: record.email,
              phone: record.phone,
              idCard: record.idCard,
              deptId: record.deptId
            }
          )
          this.userId = record.id
            // 加载已有数据
          this.sysUserOwnRole(record.id)
        } else {
          // 新增
          this.isEdit = false
          // 重置id
          this.userId = undefined
          // 重置表单
           this.form.setFieldsValue({})
           this.form.getFieldDecorator('roleIds', { valuePropName: 'checked', initialValue: undefined })
           this.selectedRowKeys = []
        }
        // 获取全部列表,无需分页
        listSelect().then((res) => {
          this.loadData = res.result
        })
        // this.getPosList()
      },
      delay: async function (interval) {
        return new Promise((resolve) => setTimeout(resolve, interval))
      },
      /**
       * 获取机构树，并加载于表单中
       */
      getOrgDate () {
        tree().then((res) => {
          this.orgTree = res.result
        })
        list().then((res) => {
          this.orgList = res.result.data
        })
      },

      /**
       * 获取职位list列表
       */
      // getPosList(){
      //   sysPosList().then((res) => {
      //     this.posList=res.data
      //   })
      // },

      compareToFirstPassword (rule, value, callback) {
        const form = this.form
        if (value && value !== form.getFieldValue('password')) {
          callback(new Error('请确认两次输入密码的一致性！'))
        } else {
          callback()
        }
      },
      validateToNextPassword (rule, value, callback) {
        const form = this.form
        if (value && this.confirmDirty) {
          form.validateFields(['confirm'], { force: true })
        }
        callback()
      },

      /**
       * 选择树机构，初始化机构名称于表单中
       */
      initrOrgName (value) {
        this.form.getFieldDecorator('deptId', {
          initialValue: this.orgList.find(item => value === (item.id + '')).label
        })
      },

      /**
       * 子表单json重构
       */
      JsonReconsitution () {
        this.sysEmpParamExtList = []
        const newData = [ ...this.data ]
        newData.forEach(item => {
          if (item.extOrgId !== '' & item.extPosId !== '') {
            this.sysEmpParamExtList.push({ orgId: item.extOrgId, posId: item.extPosId })
          }
        })
      },
      /**
        * 获取用户已有角色
        */
      sysUserOwnRole (id) {
        this.roleLoading = true
        get(id).then((res) => {
          debugger
          // 选中多选框
          this.form.getFieldDecorator('roleIds', { valuePropName: 'checked', initialValue: res.result.roleIds.map(item => item + '') })
          // this.selectedRowKeys = res.result.roleIds.map(item => item + '')
          this.roleLoading = false
        })
      },
      handleChange (selectedRowKeys) {
        this.selectedRowKeys = selectedRowKeys
      },
      /**
       * 日期需单独转换
       */
      // onChange (date, dateString) {
      //   if (date == null) {
      //     this.birthdayString = []
      //   } else {
      //     this.birthdayString = moment(date).format('YYYY-MM-DD')
      //   }
      // },
      handleSubmit () {
        const { form: { validateFields } } = this

        this.confirmLoading = true
        validateFields(async (errors, values) => {
          if (!errors) {
            // this.JsonReconsitution()
            // values.sysEmpParam['extIds'] = this.sysEmpParamExtList
            // if (this.birthdayString.length > 0) {
            //   values.birthday = this.birthdayString
            // }
            // 部门数据结构重新赋值
            // values.deptId = values.orgId
            // debugger
            // values.roleIds = this.selectedRowKeys.map(item => Number(item))
            if (this.isEdit) {
              try {
                values.id = this.userId
                const res = await update(values)
                if (res.status === 200) {
                  this.$message.success('编辑成功')
                  this.confirmLoading = false
                  this.$emit('ok', values)
                  this.handleCancel()
                } else {
                  this.$message.error('编辑失败：' + res.message)
                }
              } finally {
                this.confirmLoading = false
              }
            } else {
              save(values).then((res) => {
                if (res.status === 200) {
                  this.$message.success('新增成功')
                  this.confirmLoading = false
                  this.$emit('ok', values)
                  this.handleCancel()
                } else {
                  this.$message.error('新增失败：' + res.message)
                }
              }).finally((res) => {
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
        // 清理子表单中数据
        this.data = []
        // 清理时间
        this.birthdayString = []
      }
    }
  }
</script>
