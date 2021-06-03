<template>
    <div class="container">
        <h1>Welcome to the spotify listener tracer</h1>
        <p> Below you can see your info</p>

    </div>
</template>

<script>
    export default {
        name: "home",
        data: () => ({
            Songs: [],
            loading: true,
        }),
        created() {
            const config = {
                method: "get",
                url: "http://localhost:8080/Songs/GetAllSongs"
            };
            this.$axios(config)
                .then((result) => {
                    this.Songs = result.data;
                    this.loading = false;
                })
                .catch((error) => {
                    console.error(error)
                })
        }
    }
</script>

<style scoped>

</style>