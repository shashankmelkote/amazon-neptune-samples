/*
Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy of this
software and associated documentation files (the "Software"), to deal in the Software
without restriction, including without limitation the rights to use, copy, modify,
merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.amazonaws.services.neptune.examples.social.tasks;

import java.nio.ByteBuffer;

public class EdgeInfo {
    private final String fromVertexId;
    private final String toVertexId;
    private final String creationDate;

    public EdgeInfo(String fromVertexId, String toVertexId, String creationDate) {
        this.fromVertexId = fromVertexId;
        this.toVertexId = toVertexId;
        this.creationDate = creationDate;
    }

    public ByteBuffer bytes(){
        return ByteBuffer.wrap(String.format(
                "{ \"fromId\" : \"%s\", \"toId\" : \"%s\", \"creationDate\" : \"%s\" }",
                fromVertexId,
                toVertexId,
                creationDate).getBytes());
    }

    public String partitionKey() {
        return fromVertexId;
    }
}