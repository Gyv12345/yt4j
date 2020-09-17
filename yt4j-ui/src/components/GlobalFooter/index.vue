<template>
  <global-footer class="footer custom-render">
    <template v-slot:links>
      <a href="https://github.com/Gyv12345/yt4j-boot" target="_blank">Github</a>
    </template>
    <template v-slot:copyright>
      <a href="https://www.yt4j.cn" target="_blank">阳少的小站</a>
    </template>
  </global-footer>
</template>

<script>
import { GlobalFooter } from '@ant-design-vue/pro-layout'

export default {
  name: 'ProGlobalFooter',
  components: {
    GlobalFooter
  }
}
</script>
