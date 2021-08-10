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
package rafael.alcocer.caldera.serde;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import rafael.alcocer.caldera.deserializer.CustomDeserializer;
import rafael.alcocer.caldera.model.Model;
import rafael.alcocer.caldera.serializer.CustomSerializer;

public class CustomSerde implements Serde<Model> {

    private CustomSerializer<Model> serializer = new CustomSerializer<>();
    private CustomDeserializer<Model> deserializer = new CustomDeserializer<>();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        serializer.configure(configs, isKey);
        deserializer.configure(configs, isKey);
    }

    @Override
    public Serializer<Model> serializer() {
        return new CustomSerializer<Model>();
    }

    @Override
    public Deserializer<Model> deserializer() {
        return new CustomDeserializer<Model>();
    }

    @Override
    public void close() {
        serializer.close();
        deserializer.close();
    }
}
