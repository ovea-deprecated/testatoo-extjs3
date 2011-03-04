/*
 * Copyright (C) 2008 Ovea <dev@testatoo.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

Ext.onReady(function() {

    new Ext.Button({
        applyTo: 'main',
        id: 'button_1',
        text: 'Button1',
        icon: 'forward.png',
        handler:function(button) {
            button.setText('Button1 clicked');
        }
    });

    new Ext.Button({
        applyTo: 'main',
        id: 'button_2',
        text: 'Button2'
    });

    new Ext.Button({
        applyTo: 'main',
        id: 'reset',
        text: 'Reset',
        type: 'reset'
    });

    new Ext.Button({
        applyTo: 'main',
        id: 'submit',
        text: 'Submit',
        type:'submit'
    });

    new Ext.Button({
        applyTo: 'main',
        disabled: true,
        id: 'disabled_button',
        text: 'disabled_button'
    });

    new Ext.Button({
        applyTo: 'main',
        hidden: true,
        id: 'hidden_button',
        text: 'hidden_button'
    });

    new Ext.form.Checkbox({
        applyTo: 'error',
        id: 'buttonError'
    });

});
