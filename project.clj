(defproject me.arrdem/lighter "_"
  :description "Brilliant Clojure syntax highlighting."
  :url "https://github.com/arrdem/lighter"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths      ["src/main/clj"
                      "src/main/cljc"]
  :java-source-paths ["src/main/jvm"]
  :resource-paths    ["src/main/resources"]

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/tools.analyzer.jvm "LATEST"]
                 [rewrite-clj "0.6.0"]]

  :plugins [[me.arrdem/lein-git-version "2.0.3"]]

  :git-version
  {:status-to-version
   (fn [{:keys [tag version branch ahead ahead? dirty?] :as git}]
     (assert (re-find #"\d+\.\d+\.\d+" tag)
             "Tag is assumed to be a raw SemVer version")
     (if (and tag (not ahead?) (not dirty?))
       tag
       (let [[_ prefix patch] (re-find #"(\d+\.\d+)\.(\d+)" tag)
             patch            (Long/parseLong patch)
             patch+           (inc patch)]
         (format "%s.%d-%s-SNAPSHOT" prefix patch+ branch))))}

  :profiles
  {:test {:test-paths     ["src/test/clj"
                           "src/test/cljc"]
          :resource-paths ["src/test/resources"]}

   :dev {:dependencies []}})
