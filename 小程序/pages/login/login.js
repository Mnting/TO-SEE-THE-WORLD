var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    country:'',
    province:'',
    city:'',
    phone: '',
    password: '',
    openid:''
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log('onLoad login')
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  // 获取输入账号 
  phoneInput: function (e) {
    this.setData({
      phone: e.detail.value
    })
  },

  // 获取输入密码 
  passwordInput: function (e) {
    this.setData({
      password: e.detail.value
    })
  },// 绑定
  login: function () {
    if (this.data.phone.length == 0 || this.data.password.length == 0) {
      wx.showToast({
        title: '用户名和密码不能为空',
        icon: 'loading',
        duration: 2000
      })
    } else if (this.data.phone.lenth != 0 && this.data.password.lenth != 0) {
      wx.request({
        url: 'http://localhost:8080/Demo01/savephone',
        data: {
          country: getApp().globalData.userInfo.country,
          province: getApp().globalData.userInfo.province,
          city: getApp().globalData.userInfo.city,
          username: this.data.phone,
          password: this.data.password,
          openid: getApp().globalData.openid
        },
        method: 'GET',
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          console.log(res.data);
          wx.showToast({
            title: '绑定成功',
            icon: 'success',
            // duration: 2000
          })
          wx.navigateBack({
            url: '/pages/index/index',
          })
        },
        fail: function (res) {
          console.log(".....fail.....");
        }
      })
      // 这里修改成跳转的页面 
    }
  }
})