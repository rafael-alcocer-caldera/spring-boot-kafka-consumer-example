/**
 * Copyright [2021] [RAFAEL ALCOCER CALDERA]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rafael.alcocer.caldera.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

@Component
public class Consumer {

    @KafkaListener(topics = "#{'${spring.kafka.consumer.topic-name}'}", containerFactory = "jsonObjectKafkaListenerContainerFactory")
    public void processMessage(JSONObject json) {
        System.out.println("##### JSONObject received: " + json);
    }
}