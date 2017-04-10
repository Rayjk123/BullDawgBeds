function initMap() {
    var uluru = {lat: 33.950747, lng: -83.375816};
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 17,
        center: uluru
    });
    var marker = new google.maps.Marker({
        position: uluru,
        map: map
    });
}

$(document).ready(function () {
        $.fn.popup.defaults.transition = 'all 0.3s';
        $.fn.popup.defaults.pagecontainer = '.container';
        $('#my_popup').popup();

});
