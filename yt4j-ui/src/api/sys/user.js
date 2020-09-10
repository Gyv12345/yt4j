import request from '@/utils/request'

const api = {
  list: '/sys/user/list',
  get: '/sys/user/get/',
  save: '/sys/user/insert',
  update: '/sys/user/update',
  del: 'sys/user/delete/',
  password: '/sys/user/update/password'
}

// 分页查询
export function list (parameter) {
  return request({
    url: api.list,
    method: 'get',
    params: parameter
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
export function save (user) {
  return request({
    url: api.save,
    method: 'post',
    data: user
  })
}
// 修改
export function update (user) {
  return request({
    url: api.update,
    method: 'put',
    data: user
  })
}

// 删除
export function del (id) {
  return request({
    url: api.del + id,
    method: 'delete'
  })
}

// 重置密码密码
export function password (id) {
  return request({
    url: api.password,
    method: 'put',
    data: id
  })
}
