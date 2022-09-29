var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');

canvas.width = window.innerWidth - 100;
canvas.height = window.innerHeight - 100;

var dino = {
    x : 10,
    y : 200,
    width : 50,
    height : 50,
    draw() {
        ctx.fillstyle = 'green';
        ctx.fillRect (this.x, this.y, this.width, this.height);
    }
};


class Cactus {
    constructor(){
        this.x = 500;
        this.y = 200;
        this.width = 50;
        this.height = 50;
    }
    draw() {
        ctx.fillstyle = 'red';
        ctx.fillRect (this.x, this.y, this.width, this.height);
    }
}

var timer = 0;
var cactuies = [];

function doItforPrame() {
    requestAnimationFrame(doItforPrame);
    timer++;
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    if ( timer % 120 == 0){
        var cactus= new Cactus();
        cactuies.push(cactus);
    }

    cactuies.forEach((a, i, o)=>{
        // x 좌표가 0미만이면 제거
        if (a.x < 0) {
            o.splice(i, 1)
        }
        a.x--;
        a.draw();
    })
    dino.draw();
}

doItforPrame();

var jumping = false;
document.addEventListener('keydown', function(event)){
    if (event.code === 'Space'){

    }
}
dino.y -= 2;