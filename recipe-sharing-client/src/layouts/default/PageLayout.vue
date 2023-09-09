<template>
  <v-main class="main">
    <v-row class="top-menu-row">
      <v-col class="top-menu-col">
        <v-card class="top-menu-card" md="4" :flat="true">
          <v-card-title>{{ $route.name }}</v-card-title>
          <v-divider :thickness="1"></v-divider>
        </v-card>
      </v-col>
    </v-row>
    <v-row class="page-content">
      <v-col>
        <router-view />
      </v-col>
    </v-row>
  </v-main>
</template>

<script lang="ts" setup>
  //
</script>