"""Interface for Stanford NLP Tools"""

(ns nlpipeline.nlp
  (:gen-class))


(import java.util.Properties)

; TODO: multiple imports on one line?
(import edu.stanford.nlp.pipeline.StanfordCoreNLP)
(import edu.stanford.nlp.ling.CoreAnnotations$SentencesAnnotation)
(import edu.stanford.nlp.ling.CoreAnnotations$TokensAnnotation)
(import edu.stanford.nlp.ling.CoreAnnotations$TextAnnotation)
(import edu.stanford.nlp.ling.CoreAnnotations$PartOfSpeechAnnotation)
(import edu.stanford.nlp.ling.CoreAnnotations$LemmaAnnotation)
(import edu.stanford.nlp.ling.CoreAnnotations$LengthAnnotation)
(import edu.stanford.nlp.ling.CoreAnnotations$NamedEntityTagAnnotation)


(def annotation2class {
  :length CoreAnnotations$LengthAnnotation
  :sentences CoreAnnotations$SentencesAnnotation
  :tokens CoreAnnotations$TokensAnnotation
  :pos CoreAnnotations$PartOfSpeechAnnotation
  :lemma CoreAnnotations$LemmaAnnotation
  :tokentext CoreAnnotations$TextAnnotation})

(defn get-field
  [annotation child-type]
  {:pre (contains? annotation2class child-type)} ; TODO: why isn't this working
  (.get annotation (annotation2class child-type)))


(defn make-pipeline
  "Instantiate and return a StanfordCoreNLP object."
  [annotators]
  (let [props (java.util.Properties.)]
    (.setProperty props "annotators" annotators)
    (StanfordCoreNLP. props true)))

(def default-pipeline (make-pipeline "tokenize,ssplit,pos,lemma"))

(defn extract-tokens
  "Extract the text, POS, and lemma for each token in the sentence."
  [sent]
  (map (fn [tok]
    { "text" (get-field tok :tokentext) 
      "pos" (get-field tok :pos) 
      "lemma" (get-field tok :lemma)})
    (get-field sent :tokens)))


(defn extract-doc
  "Return a list of sentences. Each token in each sentence is a map"
  [doc-ann]
  (map extract-tokens (get-field doc-ann :sentences)))


(defn process-doc
  ([doc-text pipeline] (extract-doc (.process pipeline doc-text)))
  ([doc-text] (process-doc doc-text default-pipeline)))


(defn -main
  "Print the processed document at the 0th argument."
  [& args] (println (process-doc (second args))))
