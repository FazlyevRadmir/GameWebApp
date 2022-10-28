document.addEventListener("DOMContentLoaded", function() {

    document.getElementById('textarea').onkeyup = function () {
        document.getElementById('count').innerHTML = "Characters left: " + (500 - this.value.length);
    };

});

function specialText(element, event)
{
    if (
        event.keyCode == 69 ||
        event.keyCode == 189 ||
        element.value.length >= 100
    ) {
        return false;
    }
}