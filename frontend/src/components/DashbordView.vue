<template>

    <v-data-table
        :headers="headers"
        :items="dashbord"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DashbordView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "name", value: "name" },
                { text: "ticketid", value: "ticketid" },
                { text: "stock", value: "stock" },
                { text: "orderid", value: "orderid" },
                { text: "reservestatus", value: "reservestatus" },
                { text: "point", value: "point" },
                { text: "pointstatus", value: "pointstatus" },
            ],
            dashbord : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/dashbords'))

            temp.data._embedded.dashbords.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.dashbord = temp.data._embedded.dashbords;
        },
        methods: {
        }
    }
</script>

