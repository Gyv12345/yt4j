import request from '@/utils/request'

const api = {
  list: '/sysUser/list'
}

export function list (parameter) {
  return request({
    url: api.list,
    method: 'get',
    param: parameter
  })
}
