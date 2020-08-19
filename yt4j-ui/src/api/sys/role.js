import request from '@/utils/request'

const api = {
  list: '/sys/role/list',
  get: '/sys/role/get/',
  save: '/sys/role/insert',
  update: '/sys/role/update',
  del: 'sys/role/delete/'
}

// 分页查询
export function list (parameter) {
  return request({
    url: api.list,
    method: 'get',
    param: parameter
  })
}

// 获取单个
export function get (id) {
  return request({
    url: api.get + id,
    method: 'get'
  })
}

// 修改
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

export function del (id) {
  return request({
    url: api.del + id,
    method: 'delete'
  })
}
