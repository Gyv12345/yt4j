<template>
  <a-modal
    title="编辑菜单"
    :width="1000"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleSubmit"
    @cancel="handleCancel"
    :destroyOnClose="true"
  >
    <a-spin :spinning="formLoading">
      <a-form :form="form">
        <a-form-item v-show="false">
          <a-input v-decorator="['id']" />
        </a-form-item>

        <a-row :gutter="24">
          <a-col :md="12" :sm="24">
            <a-form-item label="菜单名称" :labelCol="labelCol" :wrapperCol="wrapperCol" hasFeedback>
              <a-input
                placeholder="请输入菜单名称"
                v-decorator="['title', {rules: [{required: true, min: 1, message: '请输入菜单名称！'}]}]"
              />
            </a-form-item>
          </a-col>
          <a-col :md="12" :sm="24">
            <a-form-item
              style="width: 100%"
              :labelCol="labelCol"
              :wrapperCol="wrapperCol"
              label="菜单编号"
              hasFeedback
            >
              <a-input placeholder="请输入菜单编号" v-decorator="['label', {rules: [{required: true, min: 1, message: '请输入菜单编号！'}]}]" />
            </a-form-item>
          </a-col>
        </a-row>

        <a-row :gutter="24">

          <a-col :md="12" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="菜单层级">
              <a-radio-group
                v-decorator="['type',{rules: [{ required: true, message: '请选择菜单层级！' }]}]"
              >
                <a-radio
                  v-for="(item, index) in typeData"
                  :key="index"
                  :value="item.value"
                  @click="meneTypeFunc(item.value)"
                >
                  {{ item.label }}
                </a-radio>
              </a-radio-group>
            </a-form-item>
          </a-col>
        </a-row>

        <a-row :gutter="24">
          <a-col :md="12" :sm="24">
            <div v-if="pidShow">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="父级菜单" has-feedback>
                <a-tree-select
                  v-decorator="['parentId', {rules: [{ required: true, message: '请选择父级菜单！' }]}]"
                  style="width: 100%"
                  :dropdownStyle="{ maxHeight: '300px', overflow: 'auto' }"
                  :treeData="menuTreeData"
                  placeholder="请选择父级菜单"
                  treeDefaultExpandAll
                  :replaceFields="replaceFields"
                  @change="setPid"
                >
                  <span slot="name" slot-scope="{ id }">{{ id }}</span>
                </a-tree-select>
              </a-form-item>
            </div>
            <div v-show="redirectShow">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol">
                <span slot="label">
                  <a-tooltip title="如需打开首页加载此目录下菜单，请填写加载菜单路由，设为首页后其他设置的主页将被替代">
                    <a-icon type="question-circle-o" />
                  </a-tooltip>&nbsp;
                  重定向
                </span>
                <a-input prop="redirect" placeholder="请输入重定向地址" v-decorator="['redirect']" />
              </a-form-item>
            </div>
          </a-col>
        </a-row>

        <a-divider />

        <a-row :gutter="24">
          <a-col :md="12" :sm="24">
            <div v-show="componentShow">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" hasFeedback>
                <span slot="label">
                  <a-tooltip
                    title="前端vue组件 views文件夹下路径，例：system/menu/index。注：目录级填写：RouteView(不带面包屑)，PageView(带面包屑)，菜单级内链打开http链接填写：Iframe"
                  >
                    <a-icon type="question-circle-o" />
                  </a-tooltip>&nbsp;
                  前端组件
                </span>
                <a-input
                  placeholder="请输入前端组件"
                  :disabled="componentDisabled"
                  prop="component"
                  v-decorator="['component',{rules: [{required: componentRequired, message: '请输入前端组件'}]}]"
                />
              </a-form-item>
            </div>
          </a-col>
          <a-col :md="12" :sm="24">
            <div v-if="routerShow">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" hasFeedback>
                <span slot="label">
                  <a-tooltip title="浏览器显示的URL，例：/menu，对应打开页面为菜单页面">
                    <a-icon type="question-circle-o" />
                  </a-tooltip>&nbsp;
                  路由地址
                </span>
                <a-input
                  placeholder="请输入路由"
                  v-decorator="['path', {rules: [{required: routerRequired, message: '请输入路由！'}]}]"
                />
              </a-form-item>
            </div>
            <div v-if="permissionShow">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="权限标识" hasFeedback>
                <a-input
                  placeholder="请输入权限标识"
                  v-decorator="['permission', {rules: [{required: permissionRequired, message: '请输入权限标识！'}]}]"
                />
              </a-form-item>
            </div>
          </a-col>
        </a-row>

        <a-row :gutter="24">
          <a-col :md="12" :sm="24">
            <div v-show="iconShow">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="图标">
                <a-input placeholder="请选择图标" disabled="disabled" v-decorator="['icon']">
                  <a-icon slot="addonAfter" @click="openIconSele()" type="setting" />
                </a-input>
              </a-form-item>
            </div>
          </a-col>
        </a-row>

        <a-row :gutter="24">
          <a-col :md="12" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="是否可见">
              <a-switch
                id="hidden"
                checkedChildren="是"
                unCheckedChildren="否"
                v-decorator="['hidden', { valuePropName: 'checked' }]"
              />
            </a-form-item>
          </a-col>
        </a-row>

        <a-row :gutter="24">
          <a-col :md="12" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="排序">
              <a-input-number
                style="width: 100%"
                v-decorator="['orderNo', { initialValue: 100 }]"
                :min="1"
                :max="1000"
              />
            </a-form-item>
          </a-col>
        </a-row>
      </a-form>
    </a-spin>
    <a-modal
      :width="850"
      :visible="visibleIcon"
      @cancel="handleCancelIcon"
      footer
      :mask="false"
      :closable="false"
      :destroyOnClose="true"
    >
      <icon-selector v-model="currentSelectedIcon" @change="handleIconChange" />
    </a-modal>
  </a-modal>
</template>

<script>
// import { getAppList } from '@/api/modular/system/appManage'
import { tree, save, get, update } from '@/api/sys/menu'
import IconSelector from '@/components/IconSelector'
import { remote } from '@/api/sys/dict'
export default {
  name: 'MenuEdit',
  components: { IconSelector },

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
      visibleIcon: false,
      visible: false,
      confirmLoading: false,
      // appData: [],
      menuTreeData: [],
      redirectShow: true,
      componentShow: true,
      componentDisabled: false,
      componentRequired: true,
      routerRequired: true,
      routerShow: true,
      iconShow: true,
      openTypeShow: true,
      pidShow: true,
      permissionShow: true,
      permissionRequired: true,
      // 图标组件
      currentSelectedIcon: 'pause-circle',
      typeData: [],
      openTypeData: [],
      // weightData: [],
      formLoading: true,
      linkShow: true,
      openTypeDisabled: false,
      openTypeDefault: [],
      openType: '',
      linkRequired: true,
      linkDisabled: false,
      type: '',
      pid: '',
      appDisabled: false,
      form: this.$form.createForm(this),
      replaceFields: {
        key: 'id',
        title: 'name',
        value: 'id'
      },
      menuId: undefined
    }
  },

  watch: {
    parentId (val) {
      if (val === '0') {
        // 再不能切换应用
        this.appDisabled = false
      } else {
        this.appDisabled = true
      }
    }
  },

  methods: {
    // 打开页面初始化
    async edit (record) {
      this.visible = true
      // 获取系统应用列表
      // this.getSysApplist()
      this.sysDictTypeDropDown()
      if (record !== undefined) {
        this.menuId = record.id
        const res = await get(record.id)
        record = res.result
        // 图标
        this.currentSelectedIcon = record.icon
        // 默认选中菜单项，并初始化
        this.form.getFieldDecorator('type', { valuePropName: 'checked', initialValue: record.type.toString() })
        this.meneTypeFunc(record.type.toString())

        // 默认选中的单选框
        // const visibleDef = false
        if (record.visible === 'Y') {
          this.visibleDef = true
        }
        debugger
        this.form.getFieldDecorator('hidden', { valuePropName: 'checked', initialValue: record.hidden })
        this.form.getFieldDecorator('icon', { initialValue: record.icon })
        setTimeout(() => {
          // 表单初始化赋值
          this.setMenuItem(record)
          // 菜单类型
          this.changeApplication(record.application)
        }, 100)
      } else {
        this.menuId = undefined
        this.currentSelectedIcon = record
         // 默认选中菜单项，并初始化
        this.form.getFieldDecorator('type', { valuePropName: 'checked', initialValue: '1' })
        this.meneTypeFunc('1')

        // 默认选中的单选框
        // this.form.getFieldDecorator('type',{valuePropName:'checked',initialValue:'1'})
        // this.form.getFieldDecorator('weight', { valuePropName: 'checked', initialValue: '2' })
        this.form.getFieldDecorator('hidden', { initialValue: true })
        setTimeout(() => {
          this.changeApplication(0)
        }, 100)
      }
    },

    setMenuItem (record) {
      this.form.setFieldsValue({
        id: record.id,
        title: record.title,
        label: record.label,
        application: record.application,
        redirect: record.redirect,
        component: record.component,
        permission: record.permission,
        link: record.link,
        path: record.path,
        orderNo: record.orderNo,
        remark: record.remark
      })
      this.form.getFieldDecorator('parentId', { initialValue: record.parentId })
      this.parentId = record.parentId
    },

    /**
     * 获取字典数据
     */
    sysDictTypeDropDown () {
      this.formLoading = true
      // 菜单类型
      remote('menu_level').then((res) => {
        this.typeData = res.result
        this.formLoading = false
      })
    },

    /**
     * 选择父级
     */
    setPid (value) {
      this.parentId = value
    },

    // getSysApplist () {
    //   return getAppList().then((res) => {
    //     if (res.status === 200) {
    //       this.appData = res.data
    //     } else {
    //       this.$message.warning(res.message)
    //     }
    //   })
    // },
    // 选择菜单类型
    changeApplication (value) {
      console.log(value)
      tree().then((res) => {
        debugger
        if (res.status === 200) {
          this.form.resetFields(`parentId`, [])
          this.menuTreeData = res.result
        } else {
          this.$message.warning(res.message)
        }
      })
    },

    /**
     * 选择菜单类型执行初始化表单变量
     */
    meneTypeFunc (type) {
      this.type = type
      if (type === '1' || type === '2') {
        // 图标选择显示
        this.iconShow = true
        // 路由必填，设置空值，并显示
        this.routerRequired = true
        this.form.getFieldDecorator('router', { initialValue: '' })
        this.routerShow = true
        // 重定向展示，并给空
        this.redirectShow = true
        this.form.resetFields(`redirect`, [])
        // 前端组件
        this.componentShow = true
        // 权限标识框隐藏，选填，给空值
        this.permissionShow = true
        this.permissionRequired = true
        this.form.getFieldDecorator('permission', { initialValue: '' })
      }
      if (type === '1') {
        // 组件默认为显示，设置可输入，给默认组件 PageView，验证必填
        this.componentDisabled = false
        this.form.getFieldDecorator('component', { initialValue: 'PageView' })
        this.componentRequired = true
        // 父级初始化顶级，并将其隐藏
        // this.form.getFieldDecorator('pid', { initialValue: '0' })
        this.pidShow = false
      } else {
        if (type === '2') {
          // 组件可以手输，取消值
          this.componentDisabled = false
          this.form.getFieldDecorator('component', { initialValue: '' })
        }
        this.form.getFieldDecorator('redirect', { initialValue: '' })
        // 父级选择放开
        this.pidShow = true
        // 权限标识框显示，必填，给空值
        // this.permissionShow = true
        // this.permissionRequired = true
        this.form.getFieldDecorator('permission', { initialValue: '' })
      }
      if (type === '3') {
        // 组件设置不填，不可输入，并给空（手输的跟设置的）
        this.componentRequired = false
        this.componentDisabled = false
        this.form.resetFields(`component`, [])
        this.form.getFieldDecorator('component', { initialValue: '' })
        // 路由选填，设置空值，并隐藏
        this.routerRequired = true
        this.form.getFieldDecorator('router', { initialValue: '' })
        this.routerShow = false
        // 权限标识框显示，必填，给空值
        this.permissionShow = true
        this.permissionRequired = true
        this.form.getFieldDecorator('permission', { initialValue: '' })
        // 图标选择隐藏,并给空
        this.iconShow = false
        this.form.getFieldDecorator('icon', { initialValue: '' })
        // 取消icon
        this.form.getFieldDecorator('icon', { initialValue: '' })
      }
    },
    /**
     * 选择图标
     */
    openIconSele () {
      this.visibleIcon = true
    },
    /**
     * 图标改变触发
     */
    handleIconChange (icon) {
      // console.log('新图标：'+icon)
      this.form.getFieldDecorator('icon', { initialValue: icon })
      // this.form.resetFields(`icon`,icon);

      this.visibleIcon = false
    },
    /**
     * 关闭选择图标窗口
     */
    handleCancelIcon () {
      this.visibleIcon = false
    },
    /**
     * 表单提交
     */
    handleSubmit () {
      const {
        form: { validateFields }
      } = this
      this.confirmLoading = true
      validateFields((errors, values) => {
        if (!errors) {
          if (this.menuId === undefined) {
            save(values)
              .then((res) => {
                this.confirmLoading = false
                if (res.status === 200) {
                  this.$message.success('添加成功')
                  this.$emit('ok', values)
                  this.handleCancel()
                } else {
                  this.$message.error('添加失败：' + res.message)
                }
              })
              .finally((res) => {
                this.confirmLoading = false
              })
          } else {
            values.id = this.menuId
            if (values.type === 1) {
              values.parentId = 0
            }
            update(values)
              .then((res) => {
                this.confirmLoading = false
                if (res.status === 200) {
                  this.$message.success('编辑成功')
                  this.$emit('ok', values)
                  this.handleCancel()
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
      this.confirmLoading = false
      this.visible = false
    }
  }
}
</script>
