window.helptips = window.helptips || {};
var helptips = window.helptips;

helptips.createTip = function(id, name, prop, title, desc) {
    var propId = name + '_' + prop;
    var tipIcon = id + '_Helptip_icon';
    var tipId = id + '_Helptip';
    $(function() {
        $('#'+propId).after( '<a id="' + tipIcon + '" rel="' + id + '" class="empty helptips_icon helptips_icon_tip" onclick="$(\'#' + tipId + '\').slideToggle()"></a>' );
        $('#'+tipIcon).after(
          '<div id="'+tipId+'" style="position:relative;" class="helptips_div">'+
            '<div class="ui-dialog ui-widget helptips-dialog-widget">'+
              '<div class="ui-dialog-titlebar ui-widget-header">'+
                title+
                '<br>'+
                '<span class="normal">('+name+'.'+prop+')</span>'+
              '</div>'+
              '<div class="ui-dialog-content ui-widget-content">'+desc+'</div>'+
            '</div></div>');
        $("#"+tipId).hide();
        $("#"+tipIcon).bt({ contentSelector: '$("#'+tipId+'").html()',
          width: '350px', closeWhenOthersOpen: false, shrinkToFit: 'true',
          positions: ['right', 'top', 'left', 'bottom', 'most'],
          margin: 0, padding: 1, fill: '#ccc', strokeWidth: 1, strokeStyle: '#ccc',
          spikeGirth: 9, spikeLength: 6,
          hoverIntentOpts: {interval: 200, timeout: 800},
          cornerRadius: 0, cssClass: 'helptips_popup'
          });
    });
};

helptips.toggleAll = function() {
    $(function() {
        var allObj = $('#all_allHelptipsToggler')
        if ( allObj.hasClass('helptips_all_off') ) {
            $('.helptips_div').slideDown()
            allObj.removeClass('helptips_all_off')
            allObj.addClass('helptips_all_on')
            }
        else {
            $('.helptips_div').slideUp()
            allObj.removeClass('helptips_all_on')
            allObj.addClass('helptips_all_off')
            }
    });
};
