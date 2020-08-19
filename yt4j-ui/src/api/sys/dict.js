import request from '@/utils/request'

const api = {
  code: '/sys/dict/remote/'
}

export function remote (code) {
  return request({
    url: api.del + code,
    method: 'get'
  })
}
