import request from '@/utils/request'

const api = {
  remote: '/sys/dict/remote/',
  list: '/sys/dict',
  get: '/sys/dict/',
  save: '/sys/dict/insert',
  update: '/sys/dict/update',
  del: '/sys/dict/delete/'
}

/**
 * 远程字典
 * @param {*} code
 */
export function remote (code) {
  return request({
    url: api.remote + code,
    method: 'get'
  })
}

/**
 * 查询所有字典
 * 分页
 */
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

// 新增
export function save (dict) {
  return request({
    url: api.save,
    method: 'post',
    data: dict
  })
}

// 修改
export function update (dept) {
  return request({
    url: api.update,
    method: 'put',
    data: dept
  })
}

// 删除
export function del (id) {
  return request({
    url: api.del + id,
    method: 'delete'
  })
}
