//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    globalData: {
      userInfo: null;
        openid: null;
    }
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      // success: res => {
      //   // 发送 res.code 到后台换取 openId, sessionKey, unionId
      // }
      success: res => {
        var code = res.code
        if (code) {
          //存在code
          wx.getUserInfo({
            success: res => {
              var encryptedData = res.encryptedData
              var iv = res.iv
              console.log({ encryptedData: encryptedData, iv: iv, code: code })
              wx.request({
                url: 'http://192.168.43.69:8080/Demo01/LoginCode',
                data: { encryptedData: encryptedData, iv: iv, code: code },//iv对称解密算法初始向量
                method: 'GET',
                header: {
                  "content-type": "application/x-www-form-urlencoded"
                },
                success: function (res) {
                  console.log(res)
                  //4.解密成功后 获取自己服务器返回的结果
                  if (res.data.status == 1) {
                    getApp().globalData.userInfo = res.data.userInfo;
                    getApp().globalData.openid = res.data.userInfo.openId;
                    console.log(res.data.existence)
                    if (res.data.existence == 'false'){ 
                 wx.navigateTo({
                        url: '/pages/login/login',
                      })
                //  res.data.existence = 'true'
                    }
                    console.log(getApp().globalData.userInfo)
                  } else{
                    console.log('解密失败')
                  }
                },
                fail: function () {
                  console.log('服务器请求失败!')
                }
              })
            }
          })
        } else {
          console.log('获取用户信息失败!' + res.errMsg)
        }
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  },
  globalData: {
    userInfo: null
  }
})