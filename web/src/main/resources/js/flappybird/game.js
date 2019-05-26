(function(){
    // 游戏类
    var game = window.game = Class.extend({
        // 构造函数
        init:function(id){
            // 得到画布
            this.canvas = document.getElementById(id);
            // 上下文
            this.ctx = this.canvas.getContext('2d');
            // r那个文件的路径
            this.RtextURL = 'r.txt';
            // 自己的图片资源对象，v是图片的路径
            this.robj = null;
            this.r = {};
            // 帧编号
            this.f = 0;
            // 加载所有资源，这个函数的重点，就是调用自己的start函数
            this.loadResouces(function(){
                this.start();
            });
        },
        // 加载所有资源，这个函数的重点，就是调用自己的start函数
        loadResouces:function(callback){
            var self = this;
            // 已经加载好的图片编号
            var count = 0;
            // 提示用户，我们正在加载资源，让丫别慌！
            self.ctx.font = '30px 微软雅黑';
            self.ctx.textAlign = 'center';
            self.ctx.fillText('正在加载图片...',self.canvas.width / 2,self.canvas.height * (1 - 0.618));
            // Ajax发出请求图片资源
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function(){
                if(xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 304)){
                    // 转为对象
                    self.robj = JSON.parse(xhr.responseText);
                    // 图片总数
                    var imagesAmount = _.size(self.robj);
                    // 遍历这个对象，设置一个相似的图片Image()对象的JSON
                    for (var k in self.robj){
                        // 创建Image对象
                        self.r[k] = new Image();
                        // 发出src请求
                        self.r[k].src = self.robj[k];
                        // 监听
                        self.r[k].onload = function(){
                            // 计数器+1
                            count++;
                            // 清屏
                            self.ctx.clearRect(0,0,self.canvas.width,self.canvas.height);
                            self.ctx.fillText('正在加载图片' + count + '/' + imagesAmount,100,100);
                             // 当加载好的数量等于图片总数的时候
                            if(count == imagesAmount){
                                // 所有图片已经加载完毕，做什么事情？？
                                // 调用回调函数
                                callback.call(self);
                            }
                        }
                    }
                }
            }
            xhr.open('get','r.txt',true);
            xhr.send(null);
        },
        start : function(){
            // 先实例化背景然后实例化大地，因为先实例化的会先进入actors数组。就会被update和render
            // 要不然就压盖顺序错误。
            // 背景
            this.bg = new background();
            // 大地
            this.land = new land();
            // 游戏开始了
            this.timer = setInterval(function(){
                var self = this;
                // 清屏
                self.ctx.clearRect(0,0,self.canvas.width,self.canvas.height);
                // 更新所有的演员、渲染所有的演员
                _.each(self.actors,function(actor){
                    actor.update();
                    actor.render();
                });
                // 帧编号加1
                self.f++;
                self.ctx.textAlign = 'left';
                self.ctx.font = '14px Consolas';
                self.ctx.fillText('FNO' + self.f,20,20);
            },40);
        }
    });
});