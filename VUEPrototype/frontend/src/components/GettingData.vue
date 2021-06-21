<template>
    <div>
        <p>Test GETTING DATA</p>
        {{ apiInfo }}
    </div>
</template>

<script>
    //http://localhost:8080/Songs/GetAllSongs
    const axios = require('axios').default;
    const config = {
        method: "get",
        url: "http://localhost:8080/Songs/GetAllSongs/"
    };


    export default {
        name: "GettingData",
        methods() {
          this.mounted()
        },
        data() {
            return {
                apiInfo: null,
                loading: true
            }
        },
        mounted() {
            axios(config)
            .then((result) => {
                console.log((result.data));
                this.apiInfo = result.data;
                this.loading = false;
            })
            .catch((error) => {
                console.log(error);
                this.loading = false;
            })
        }
    }

</script>

<style scoped>

</style>