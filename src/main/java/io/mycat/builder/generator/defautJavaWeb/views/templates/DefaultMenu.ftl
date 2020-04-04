<template>
  <v-card>
    <v-list three-line shaped>
      <template v-for="(item,index) in items">
        <v-list-item :key="item.title" @click="$router.push(item.link)">
          <v-badge :color="item.color" :content="item.tip">
            <v-icon color="primary" large>{{item.src}}</v-icon>
          </v-badge>
          <v-list-item-content>
            <v-list-item-subtitle style="margin-left: 10px">
              <b>{{item.title}}:</b>
              {{item.note}}
            </v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-divider :key="index" inset></v-divider>
      </template>
    </v-list>
  </v-card>
</template>
<!--
<template>
  <v-card  class="mx-auto" top="0">
    <v-container top="0" >
      <v-row dense>
        <v-col v-for="(item, i) in items" :key="i" cols="12"  @click="$router.push(item.link)">
          <v-card :color="item.color" dark style="cursor: pointer">
            <div class="d-flex flex-no-wrap " >
              <v-avatar>
                <v-img :src="item.src" wrap></v-img>
              </v-avatar>
              <v-card-subtitle class="text-left" >{{'【'+item.title+'】'+item.note}}</v-card-subtitle>
            </div>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>
-->
<script>
export default {
  data: () => ({
    items: [
      <#list view.menus as menu >
      {
        color: 'cyan',
        tip: '79',
        src: '${menu.icon}',
        title: '${menu.title} ',
        link: '${menu.routeView.link}',
        note:
          '.....loading......'
      }
      <#if menu_has_next>,</#if>
      </#list>
    ]
  })
}
</script>
