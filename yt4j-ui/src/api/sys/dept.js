import request from '@/utils/request'

const api = {
  tree: '/sys/dept/tree',
  get: '/sys/dept/get/',
  save: '/sys/dept/insert',
  update: '/sys/dept/update',
  del: 'sys/dept/delete/'
}

// 查询所有机构,左侧树
export function tree () {
  return request({
    url: api.tree,
    method: 'get'
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
export function save (dept) {
  return request({
    url: api.save,
    method: 'post',
    data: dept
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

export function del (id) {
  return request({
    url: api.del + id,
    method: 'delete'
  })
}
