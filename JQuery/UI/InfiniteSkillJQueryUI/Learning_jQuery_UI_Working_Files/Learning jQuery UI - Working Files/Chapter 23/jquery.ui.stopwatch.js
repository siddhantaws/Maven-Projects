(function ($) {
    var instance;
    $.widget('ui.stopwatch', {
        options: {
            startText: 'Start',
            stopText: 'Stop'
        },
        _create: function () {
            instance = this;
            this.element.addClass('ui-widget ui-stopwatch');
            this.display = $('<span/>', {
                'class': 'ui-stopwatch-display',
                text: 0
            });
            this.buttons = {};
            this._makeButton('start', this.options.startText);
            this._makeButton('stop', this.options.stopText);

            this.element.append(this.display);
            $.each(this.buttons, function (index, item) {
                instance.element.append(item);
            });

            this._on(this.element, {
                'click #start': this.start,
                'click #stop': this.stop
            });
        },
        _makeButton: function (name, text) {
            this.buttons[name] = $('<button/>', {
                'class': 'ui-stopwatch-button',
                text: text,
                id: name
            });
        },
        _destroy: function () {
            this._off(this.element, 'click');
            this.element.removeClass('ui-widget ui-stopwatch');
            this.element.empty();
        },
        _setOption: function (key, value) {
            var name = key.split('Text')[0];
            this.buttons[name].text(value);
            this._super(key, value);
        },
        start: function () {
            this.value = parseInt(this.display.text(), 10);
            this.timer = setInterval(this._update, 1);
            this._trigger('start', event, {
                button: this.buttons.start
            });
        },
        stop: function () {
            clearInterval(this.timer);
            this._trigger('stop', event, {
                button: this.buttons.stop
            });
        },
        _update: function () {
            instance.value = parseInt(instance.value, 10) + 1;
            instance.display.text(instance.value / 1000);
        }
    });
}(jQuery));