import request from '@/utils/request'

const api = {
  list: '/sys/dict/item',
  get: '/sys/dict/item/',
  save: '/sys/dict/item',
  update: '/sys/dict/item',
  del: '/sys/dict/item/delete/'
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
