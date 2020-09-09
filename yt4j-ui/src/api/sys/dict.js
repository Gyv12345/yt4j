import request from '@/utils/request'

const api = {
  remote: '/sys/dict/remote/'
}

export function remote (code) {
  return request({
    url: api.remote + code,
    method: 'get'
  })
}
