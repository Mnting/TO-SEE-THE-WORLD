// page/component/orders/orders.js
Page({
  data:{
    address:{},
    hasAddress: false,
    total:0,
    orders:[
        {id:1,title:'储物盒子',image:'/image/s5.jpg',num:1,price:240.00},
        {id:2,title:'简约沙发',image:'/image/s6.jpg',num:1,price:198.00}
      ]
  },

  onReady() {
    this.getTotalPrice();
  },
  
  onShow:function(){
    const self = this;
    wx.getStorage({
      key:'address',
      success(res) {
        self.setData({
          address: res.data,
          hasAddress: true
        })
      }
    })
  },

  /**
   * 计算总价
   */
  getTotalPrice() {
    let orders = this.data.orders;
    let total = 0;
    for(let i = 0; i < orders.length; i++) {
      total += orders[i].num * orders[i].price;
    }
    this.setData({
      total: total
    })
  },

  toPay() {
    wx.showModal({
      title: '提示',
      content: '不会',
      complete() {
        wx.switchTab({
          url: '/page/component/user/user'
        })
      }
    })
  }
})