<template>
    <div>
        <h1>Your Song listen history</h1>
        <p> {{apiInfo}}</p>

        <table id="songView">'
            <tr>
                <th>Listing place</th>
                <th>Artist</th>
                <th>Song</th>
            </tr>
            <tr v-for="(songInfo) in apiInfo" v-bind:key="songInfo">
                <td>{{songInfo.Id}}</td>
                <td>{{songInfo.Artist}}</td>
                <td>{{songInfo.Name}}</td>/
            </tr>
        </table>
    </div>
</template>

<script>
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
                loading: true,
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
                errored: false
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
                this.errored = true
            })
        }
    }

</script>

<style scoped>
    #songView {
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #songView td, #songView th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #songView tr:nth-child(even){background-color: #f2f2f2;}

    #songView tr:hover {background-color: #ddd;}

    #songView th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: #04AA6D;
        color: white;
    }
</style>