<template>
  <ul>
    <li><a class="active" href="/">Home</a></li>
    <div class="dropdown"><li><a class="" href="/">Juju124</a></li>
    <div class="dropdownContent">
      <a class="" href="">Personal Info</a>
      <a class="" href="">Recent Songs</a>
      <a class="" href="">Saved Info</a>
      <a class="" href="">Logout</a>
    </div>
  </div>
  </ul>
</template>

<script>
 export default  {
   name: 'App'
 }
</script>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }

  ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
  }

  li {
    float: left;
  }

  li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
  }

  li a:hover {
    background-color: #111;
  }

  .dropdown {
    position: relative;
    display: inline-block;
  }

  .dropdownContent {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    padding: 12px 16px;
    z-index: 1;
  }

  .dropdown:hover .dropdownContent {
    display: block;
  }

  .dropdownContent a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
  }
</style>
