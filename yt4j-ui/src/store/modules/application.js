// api
import { getApplication } from '@/api/sys/menu'

const application = {
  state: {
    applicationList: [],
    applicationCode: 1
  },
  mutations: {
    SET_APPLICATION_LIST: (state, data) => {
      state.applicationList = data
    },
    SET_APPLICATION_CODE: (state, data) => {
      state.applicationCode = data
    }
  },
  actions: {
    GetApplicationList ({ commit, state }) {
      return new Promise(async resolve => {
        const res = await getApplication()
        // 保存应用菜单
        commit('SET_APPLICATION_LIST', res.result)
        console.log(state.applicationCode)
        // 默认值
        commit('SET_APPLICATION_CODE', state.applicationCode)
        resolve()
      })
    },
    SetApplicationCode ({ commit }, code) {
        // return new Promise(resolve => {
        commit('SET_APPLICATION_CODE', code)
        commit('SET_ROLES', [])
        //   resolve()
        // })
      }
  }
}

export default application
