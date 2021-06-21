<template>
    <div class="container">
        <v-data-table
                :headers="columns"
                :items="Songs"
                :items-per-page="15"
                class="elevation-1"
        ></v-data-table>
        <p>{{msg}}</p>
        <p>Test</p>
    </div>
</template>

<script>
    export default {
        name: "Home",
        created () {
            alert("Your in the home view");

            const config = {
                method: "get",
                url: "http://localhost:8080/Songs/GetAllSongs"
            };
            this.$axios(config)
                .then((result) => {
                    console.log(result.data);
                    this.Songs = result.data;
                    this.loading = false;
                })
                .catch((error) => {
                    console.log(error);
                    this.loading = false;
                })
        },
        data: () => ({
            columns: [
                {
                    id: "key1",
                    title: "songName",
                    name: "Song Name",
                },
                {
                    id: "key2",
                    title: "songArtist",
                    name: "Artist"
                }
            ],
            Songs: [],
            loading: true,
        }),
        msg: "Test message",
    }
</script>

<style scoped>
    .container {
        display: block;
    }
</style>