(function(){
    var land = window.land = CLass.extend({
        init : function(){
            // 自己的图片
            this.image = game.r.land;
            this.x= 0;
            this.speed = 4
            // 调用超类的构造函数，把自己放入game的actors数组中
            this._super();
        },
        update : function(){
            this.x -= this.speed;
            if(this.x < -336){
                this.x = 0;
            }
        },
        render : function(){
            game.ctx.drawImage(this.image,this.x,520-112);
            game.ctx.drawImage(this.image,this.x + 336,520-112);
            game.ctx.drawImage(this.image,this.x + 336*2,520-112);
        }
    });
})();