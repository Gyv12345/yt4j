import request from '@/utils/request'

const api = {
  list: '/sys/role/list',
  get: '/sys/role/get/',
  save: '/sys/role/insert',
  update: '/sys/role/update',
  del: 'sys/role/delete/',
  getMenuByRole: '/sys/role/get/menus/',
  setMenuByRole: '/sys/role/setting',
  listSelect: '/sys/role/select'
}

// 分页查询
export function list (parameter) {
  return request({
    url: api.list,
    method: 'get',
    params: parameter
  })
}

// 角色下拉菜单
export function listSelect () {
  return request({
    url: api.listSelect,
    method: 'get'
  })
}

// 获取单个角色权限
export function getMenuByRole (id) {
  return request({
    url: api.getMenuByRole + id,
    method: 'get'
  })
}

// 新增
export function setMenuByRole (data) {
  return request({
    url: api.setMenuByRole,
    method: 'post',
    data: data
  })
}

// 获取单个
export function get (id) {
  return request({
    url: api.get + id,
    method: 'get'
  })
}

// 新增
export function save (role) {
  return request({
    url: api.save,
    method: 'post',
    data: role
  })
}

// 修改
export function update (role) {
  return request({
    url: api.update,
    method: 'put',
    data: role
  })
}

// 删除
export function del (id) {
  return request({
    url: api.del + id,
    method: 'delete'
  })
}
