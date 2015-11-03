(ns siglab.gui)
(use '(seesaw core))

(def f (frame :title "Siglab", :size [640 :by 480] :on-close :exit))

(defn display [content]
  (config! f :content content)
  content)

(def bp (border-panel :hgap 50 :vgap 10
  :center "CENTER"
  :north  "NORTH"
  :south  "SOUTH"
  :east   "EAST"
  :west   "WEST"))

;(display bp)
(def p1 (abstract-panel :color "red"))
(def p2 (abstract-panel :color "green"))
(def p3 (abstract-panel :color "blue"))
(display p1)
(show! f)