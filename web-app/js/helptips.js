window.helptips = window.helptips || {};
var helptips = window.helptips;

helptips.createTip = function(id, name, prop, title, desc) {
    var tipIcon = id + '_Helptip_icon';
    var tipId = id + '_Helptip';
    $(function() {
        $('#'+prop).after( '<a href="#" id="' + tipIcon + '" rel="' + id + '" class="empty helptips_icon helptips_icon_tip" onclick="$(\'#' + tipId + '\').slideToggle()"></a>' );
        $('#'+tipIcon).after(
                '<div id="'+tipId+'" style="position:relative;" class="helptips_div">'+
                    '<div class="ui-dialog ui-widget">'+
                    '<div class="ui-dialog-titlebar ui-widget-header ui-corner-all">'+name+': '+prop+'<br><strong>'+title+'</strong></div>'+
                    '<div class="ui-dialog-content ui-widget-content">'+desc+'</div>'+
                '</div></div>');
        $("#"+tipId).hide();
        $("#"+tipIcon).bt({contentSelector: $("#"+tipId), width: '350px', closeWhenOthersOpen: true, shrinkToFit: 'true', positions: ['right', 'top', 'left'], margin: 0, padding: 6, fill: '#fff', strokeWidth: 1, strokeStyle: '#c2c2c2', spikeGirth: 12, spikeLength:9, hoverIntentOpts: {interval: 100, timeout: 1000}});
    });
};
