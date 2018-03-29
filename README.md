# Lab03 Soluzione 

Soluzione al terzo laboratorio TdP

### Performance evaluation

Utilizzare la classe ```TestPerformances.java``` nel package ```it.polito.tdp.spellchecker.model```.

#### ArrayList

```
Dizionario Italian loaded. Found 893249 words.
In informatica Java è un linguaggio di programmazione ad alto livello orientato agli oggetti e a tipizzazione statica specificatamente progettato per essere il più possibile indipendente dalla piattaforma di esecuzione

debug cont: [5.7766499, 4.8953979, 4.5101511, 4.7827098, 4.7493064, 4.7776151, 4.7998534, 4.5296753, 4.9736729, 4.6238885]
debug line: [12.2002828, 9.9160619, 8.5591436, 8.6584455, 8.214091, 8.3082432, 8.1474463, 8.3352695, 8.4346739, 8.2476032]
debug dich: [0.0716576, 0.0247918, 0.0213364, 0.0271199, 0.0356443, 0.0148826, 0.0108276, 0.0103604, 0.0104416, 0.0095803]

CONTAINS took:                   4.841892 ms (AVG on 10 runs)
LINEAR SEARCH took:              8.902126 ms (AVG on 10 runs)
DICHOTOMIC SEARCH took:          0.023664 ms (AVG on 10 runs)
```

#### LinkedList

```
Dizionario Italian loaded. Found 893249 words.
In informatica Java è un linguaggio di programmazione ad alto livello orientato agli oggetti e a tipizzazione statica specificatamente progettato per essere il più possibile indipendente dalla piattaforma di esecuzione

debug cont: [17.3353613, 17.4042135, 17.7960165, 18.4402569, 17.410281, 17.5731487, 16.7966221, 17.5609407, 17.4531933, 19.0804664]
debug line: [20.3304361, 18.9627941, 19.163856, 19.5466077, 18.5042614, 18.6153533, 17.7792676, 18.4844688, 18.4235167, 18.6193148]
debug dich: [598.0526411, 589.8888127, 594.0108117, 636.0212745, 601.7242692, 580.3105456, 602.5445745, 623.6218989, 641.5684472, 688.9451876]

CONTAINS took:                  17.685050 ms (AVG on 10 runs)
LINEAR SEARCH took:             18.842988 ms (AVG on 10 runs)
DICHOTOMIC SEARCH took:        615.668846 ms (AVG on 10 runs)
```
