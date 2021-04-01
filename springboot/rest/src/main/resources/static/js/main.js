var messageApi = Vue.resource('/message/{id}');

Vue.component('message-row',{
    props: ['message'],
    template:'<div><i>({{ message.id }})</i>{{ message.text }}</div>'
});

Vue.component('message-form',{
    props:['messages'],
    data: function(){
        return {
                text: ''
    }
    },
    template:
    '<div>'+
        '<input type="text" placeholder = "Write something"/>' +
        '<input type="button" value= "Save" @click = "save"/>' +
    '</div>',
    methods:{
        click: function(){
            var message = { text: this.text};
            messageApi.save({},message).then(result=>
                result.json().then(data =>{
                this.messages.push(data);
                })
            )
        }
    }
})

Vue.component('messages-list',{
    props: ['messages'],

    template: '<div>' +
        '<message-form :messages= "messages"/>'+
        '<message-row v-for= "message in messages" :key = "message.id" :message="message"/>'+
        '</div>',
    created: function() {
    messageApi.get().then(result =>
    result.json().then(
    data => data.forEach( message => this.messages.push(message))
    ))
  }
});

var app = new Vue({
  el: '#app',
  template: '<messages-list :messages = "messages"/>',
  data: {
    messages: []}
});