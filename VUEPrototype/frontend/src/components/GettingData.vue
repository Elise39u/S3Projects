<template>
    <div>
        <p>Test GETTING DATA</p>
        {{ apiInfo }}
    </div>
</template>

<script>
    //http://localhost:8080/Songs/GetAllSongs
    const axios = require('axios').default;

    export default {
        name: "GettingData",
        methods() {
          this.mounted()
        },
        data() {
            return {
                apiInfo: null
            }
        },
        mounted() {
            axios
                .get("http://localhost:8080/Songs/GetAllSongs")
                .then( response => (this.apiInfo = response))
        }
    }

</script>

<style scoped>

</style>