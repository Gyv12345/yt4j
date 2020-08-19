import request from '@/utils/request'

const api = {
  tree: '/sys/menu/tree',
  get: '/sys/menu/get/',
  save: '/sys/menu/insert',
  update: '/sys/menu/update',
  del: 'sys/menu/delete/'
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
export function save (menu) {
  return request({
    url: api.save,
    method: 'post',
    data: menu
  })
}
// 修改
export function update (menu) {
  return request({
    url: api.update,
    method: 'put',
    data: menu
  })
}

export function del (id) {
  return request({
    url: api.del + id,
    method: 'delete'
  })
}
