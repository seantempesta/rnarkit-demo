(ns rnarkit-demo.ios.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [rnarkit-demo.events]
            [rnarkit-demo.subs]))

(def ReactNative (js/require "react-native"))
(def requireNativeComponent (.-requireNativeComponent ReactNative))
(def PropTypes (js/require "prop-types"))


(def myText (clj->js {:name      "MyText"
                      :propTypes (merge {:text (.-string PropTypes)}
                                        (js->clj (.-propTypes (.-View ReactNative))))}))

(def MyText (requireNativeComponent "RNMyText", myText))
;
;// requireNativeComponent automatically resolves this to "RNTMapManager"
;module.exports = requireNativeComponent('RNTMap', null);)

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))

(def logo-img (js/require "./images/cljs.png"))

(defn alert [title]
  (.alert (.-Alert ReactNative) title))


;[:> NativeTest {:style {:flex            1
;                        :height          100
;                        :width           100
;                        :backgroundColor "blue"}}]

(defn app-root []
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [view {:style {:flex-direction "column"
                     :margin         40
                     :align-items    "center"}}

       [:> MyText {:text  "Hello World"
                   :style {:backgroundColor "transparent"
                           :width           100
                           :height          30}}]])))


;
;[text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} @greeting]
;[image {:source logo-img
;        :style  {:width 80 :height 80 :margin-bottom 30}}]
;[touchable-highlight {:style    {:background-color "#999" :padding 10 :border-radius 5}
;                      :on-press #(alert "HELLO!")}
; [text {:style {:color "white" :text-align "center" :font-weight "bold"}} "press me"]]])))

(defn init []
  (dispatch-sync [:initialize-db])
  (.registerComponent app-registry "RNArkitDemo" #(r/reactify-component app-root)))
