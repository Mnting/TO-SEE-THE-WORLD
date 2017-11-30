Page({
    data: {
        category: [
            {name:'卧室',id:'guowei'},
            {name:'浴室',id:'shucai'},
            {name:'客厅',id:'chaohuo'},
            {name:'厨房',id:'dianxin'},
            {name:'餐厅',id:'cucha'},
            {name:'阳台',id:'danfan'}
        ],
        detail:[],
        curIndex: 0,
        isScroll: false,
        toView: 'guowei'
    },
    onReady(){
        var self = this;
        wx.request({
            url:'',
            success(res){
                console.log(res.data)
                self.setData({
                    detail : res.data.result
                })
            }
        });
        
    },
    switchTab(e){
        this.setData({
            toView : e.target.dataset.id,
            curIndex : e.target.dataset.index
        })
    }
    
})