(function(){
    var background = window.background = actor.extend({
        init : function(){
            // 随机选择一个，是白天还是黑夜
            this.dayOrNight = _.random(0,1);
            // 自己的图片
            this.imageName = (['bg_day','bg_night'])[this.dayOrNight];
            // 自己的图片，自己的图片已经被game类的r加载完毕了！！！
            this.image = game.r[this.imageName];
            // x位置
            this.x = 0;
            //速度
            this.speed = 1;
            // 调用超类的构造函数，把自己放入game的actors数组中
            this._super();
        },
        update : function(){
            this.x -= this.speed;
            if(this.x < -288){
                this.x = 0;
            }
        },
        render : function(){
            // 渲染三张，目的是无缝连续滚动，当猫腻图的左边框到达0点，就拉回来。
            // 也就是x如果是-288，就让x为0
            game.ctx.drawImage(this.image,this.x,0,288,520);
            game.ctx.drawImage(this.image,this.x + 288,0,288,520);;
            game.ctx.drawImage(this.image,this.x + 288*2,0,288,520);
        }
    });
})();