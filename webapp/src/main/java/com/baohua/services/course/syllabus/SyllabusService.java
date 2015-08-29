package com.baohua.services.course.syllabus;


import com.baohua.common.paginator.Pagination;

import java.util.Map;

public interface SyllabusService {

    int createNode(int courseId, NodeType type,  String title, String description, int parentNodeId);

    void deleteNode(int courseId, int nodeId);

    Pagination<Node> getNodes(int courseId, int parentNodeId);

    void updateNode(int courseId, int nodeId, Map<String, Object> values);

}
