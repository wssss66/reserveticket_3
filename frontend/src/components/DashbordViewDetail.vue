<template>

    <v-card outlined>
        <v-card-title>
            Dashbord # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Name" v-model="item.name" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Ticketid" v-model="item.ticketid" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Stock" v-model="item.stock" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Orderid" v-model="item.orderid" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Reservestatus" v-model="item.reservestatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Point" v-model="item.point" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Pointstatus" v-model="item.pointstatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'DashbordViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/dashbords/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

