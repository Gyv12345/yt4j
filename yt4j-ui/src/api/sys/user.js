import request from '@/utils/request'

const api = {
  list: '/sys/user/list'
}

export function list (parameter) {
  return request({
    url: api.list,
    method: 'get',
    param: parameter
  })
}
